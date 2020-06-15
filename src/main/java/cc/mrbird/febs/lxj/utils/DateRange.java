package cc.mrbird.febs.lxj.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateRange {
		
		private Date start;
		private Date end;
		
		public DateRange() {
			super();
		}
		
		public DateRange(Date start, Date end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		/**
		 * 判断时间范围是否不为空，即开始时间不在结束时间之后
		 */
		public boolean isNotEmptyDateRange() {
			return start.before(end) || start.equals(end);
		}
		
		public List<DateRange> splitByMonth() {
			List<DateRange> result = new ArrayList<>();
			
			if(!this.isNotEmptyDateRange()) {
				return result;
			}
			
			Calendar sc = Calendar.getInstance();
			sc.setTime(start);
			Calendar ec = Calendar.getInstance();
			ec.setTime(end);
			
			if (this.isSameMonth(sc, ec)) {
				result.add(this);
				return result;
			}
			
			while(sc.before(ec)) {
				DateRange d = new DateRange();
				d.setStart(sc.getTime());
                //向时间点之后取整，这里以月取整，就是下月初第一天零点
                //还有一个方法是truncate是向之前的时间取整，和celling正好相反
                //为什么celling有向后取整的意思，因为吊灯，天花板，之类的英文就是celling
				sc = DateUtils.ceiling(sc, Calendar.MONTH);
                //这里主要考虑最后一个月的情况，这个if其实可以提到while外面，性能会更好一点
                //我懒得提了
				if(sc.before(ec)) {
					sc.add(Calendar.SECOND,-1);
					d.setEnd(sc.getTime());
					sc.add(Calendar.SECOND,1);
				} else {
					d.setEnd(ec.getTime());
				}
				result.add(d);
			}
			
			return result;
			
		}
		
		private boolean isSameMonth(final Calendar cal1, final Calendar cal2) {
			return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
					&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		}
		
		public Date getStart() {
			return start;
		}
		public void setStart(Date start) {
			this.start = start;
		}
		public Date getEnd() {
			return end;
		}
		public void setEnd(Date end) {
			this.end = end;
		}
		
	}
